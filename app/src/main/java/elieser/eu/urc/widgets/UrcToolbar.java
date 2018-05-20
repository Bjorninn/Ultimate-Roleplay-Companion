package elieser.eu.urc.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import elieser.eu.urc.R;

public class UrcToolbar extends RelativeLayout
{
    public ImageButton backButton;
    public ImageButton homeButton;

    public UrcToolbar(Context context)
    {
        super(context);
        init(null, 0);
    }

    public UrcToolbar(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs, 0);

    }

    public UrcToolbar(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);

    }

    public UrcToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);

    }

    private void init(AttributeSet attrs, int defStyle)
    {
        View view = inflate(getContext(), R.layout.widget_urc_toolbar, this);

        backButton = view.findViewById(R.id.back_button);
        homeButton = view.findViewById(R.id.home_button);
    }
}
