/*
 *  Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hannesdorfmann.mosby3.sample;

import android.app.Application;
import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpViewStateDelegateImpl;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author Hannes Dorfmann
 */
public class SampleApplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
        SampleApplication application = (SampleApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);

    /*
    ActivityMvpViewStateDelegateImpl.DEBUG = true;
    FragmentMvpViewStateDelegateImpl.DEBUG = true;
    ViewGroupMvpViewStateDelegateImpl.DEBUG = true;
    ActivityMvpDelegateImpl.DEBUG = true;
    FragmentMvpDelegateImpl.DEBUG=true;
    ViewGroupMvpDelegateImpl.DEBUG = true;
    */
    }
}
