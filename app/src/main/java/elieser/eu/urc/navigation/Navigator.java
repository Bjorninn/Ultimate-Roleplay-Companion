package elieser.eu.urc.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Constructor;

import elieser.eu.urc.R;

public final class Navigator
{
    private static Class currentScene = null; //TODO change to start scene

    private Navigator()
    {

    }

    public static Fragment getCurrentScene(AppCompatActivity activity)
    {
        return activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    public static void clearBackStackToHome(AppCompatActivity activity)
    {
        activity.getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        FragmentManager manager = activity.getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0)
        {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public static int navigationEvent(Class<? extends android.support.v4.app.Fragment> clazz, AppCompatActivity activity)
    {
        return navigationEvent(clazz, null, activity);
    }

    public static int navigationEvent(Class<? extends android.support.v4.app.Fragment> clazz, Bundle bundle, AppCompatActivity activity)
    {
        try
        {
            Constructor<?> constructor = clazz.getConstructors()[0];
            android.support.v4.app.Fragment fragment = (Fragment) constructor.newInstance();
            if (bundle != null)
            {
                fragment.setArguments(bundle);
            }

            return navigationEvent(fragment, activity);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    public static int navigationEvent(Fragment fragment, AppCompatActivity activity)
    {
        currentScene = fragment.getClass();

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_left, R.animator.slide_out_right);
        //transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.add(R.id.fragment_container, fragment, fragment.getClass().getName());
        transaction.addToBackStack(currentScene.getName());
        return transaction.commit();
    }

    public static boolean popFragmentBackStack(AppCompatActivity activity)
    {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        boolean didPop = fragmentManager.popBackStackImmediate();

        if (didPop)
        {
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
            currentScene = fragment.getClass();
        }

        return didPop;
    }

    public static void popFragmentBackStackToScene(String name, AppCompatActivity activity)
    {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        fragmentManager.popBackStackImmediate(name, 0);

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        currentScene = fragment.getClass();
    }

    public static void popFragmentBackStackToBottom(AppCompatActivity activity)
    {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        currentScene = fragment.getClass();
    }

    public static boolean emptyFragmentBackStack(AppCompatActivity activity)
    {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        int id = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getId();

        return fragmentManager.popBackStackImmediate(id, 0);
    }
}

