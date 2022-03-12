package fr.delcey.hiltuitest;

import android.app.Application;
import android.content.Context;

import androidx.test.runner.AndroidJUnitRunner;

import dagger.hilt.android.testing.HiltTestApplication;

@SuppressWarnings("unused") // Used in build.gradle !
public final class HiltAndroidTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(
        ClassLoader cl,
        String className,
        Context context
    ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return super.newApplication(cl, HiltTestApplication.class.getName(), context);
    }
}