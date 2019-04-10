package com.android.newyorkdev.ui.base;

import android.content.Context;

/**
 * MAIN BASE VIEW INTERFACE
 * THIS INTERFACE WILL BE USED AS BASE VIEW FOR ALL
 * IMPLEMENTATIONS FOR ALL INTERFACES THAT HAVE VIEW
 *
 * @param <T> - ASK MAHMOUD !
 */
public interface BaseView<T> {
    /**
     * return the current context
     *
     * @return - context
     */
    Context getMyContext();


}