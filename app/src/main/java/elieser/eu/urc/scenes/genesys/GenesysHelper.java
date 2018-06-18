package elieser.eu.urc.scenes.genesys;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import elieser.eu.urc.R;

public class GenesysHelper
{
    public static GenesysHelper instance;

    private Typeface eoteTypeface;

    public GenesysHelper(AssetManager assetManager)
    {
        super();

        instance = this;

        eoteTypeface = Typeface.createFromAsset(assetManager, "EotE_Symbol-Regular_v1.otf");
//        eoteTypeface = Typeface.createFromAsset(assetManager, "EotESymbol-Regular-PLUS.otf");

    }

    public Spannable createBoostOrSetbackDicePool(Context context, int count, boolean isBoost)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++)
        {
            builder.append("b");
        }

        Spannable spannable = new SpannableString(builder.toString());

        CustomTypefaceSpan span = new CustomTypefaceSpan(eoteTypeface);
        spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan colorSpan;

        if (isBoost)
        {
            colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.boost_blue));
        }
        else
        {
            colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.black));
        }

        spannable.setSpan(colorSpan, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        return spannable;
    }

    public Spannable createDicePool(Context context, int characteristic, int skill)
    {
        int larger = Math.max(characteristic, skill);
        int smaller = Math.min(characteristic, skill);
        int leftovers = larger - smaller;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < smaller; i++)
        {
            builder.append("c");
        }

        for (int i = 0; i < leftovers; i++)
        {
            builder.append("d");
        }

        Spannable spannable = new SpannableString(builder.toString());

        CustomTypefaceSpan span = new CustomTypefaceSpan(eoteTypeface);
        spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan green = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.ability_green));

        if (smaller > 0)
        {
            ForegroundColorSpan yellow = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.proficiency_yellow));
            spannable.setSpan(yellow, 0, smaller, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannable.setSpan(green, smaller, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else
        {
            spannable.setSpan(green, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        return spannable;
    }
}
