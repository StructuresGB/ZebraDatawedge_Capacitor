package com.structuresgb.plugins.datawedge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "ZebraDataWedge")
public class ZebraDataWedgePlugin extends Plugin {
    private static final String LOG_TAG = "ZebraDataWedgePlugin";

    private ZebraDataWedge implementation = new ZebraDataWedge();

    @Override
    public void load() {
        Bridge capacitorBridge = bridge;
        Context context = capacitorBridge.getContext();

        IntentFilter filter = new IntentFilter();
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        filter.addAction(context.getResources().getString(R.string.activity_intent_filter_action));
        context.registerReceiver(scannerBroadcastReceiver, filter);
        Log.v(LOG_TAG, "Listening to " + context.getResources().getString(R.string.activity_intent_filter_action) + " intent");
    }
    private final BroadcastReceiver scannerBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            assert action != null;
            if (action.equals(context.getResources().getString(R.string.activity_intent_filter_action))) {
                //  Received a barcode scan
                String decodedSource = intent.getStringExtra(context.getResources().getString(R.string.datawedge_intent_key_source));
                String decodedData = intent.getStringExtra(context.getResources().getString(R.string.datawedge_intent_key_data));
                String decodedLabelType = intent.getStringExtra(context.getResources().getString(R.string.datawedge_intent_key_label_type));

                JSObject ret = new JSObject();
                ret.put("source", decodedSource);
                ret.put("data", decodedData);
                ret.put("labelType", decodedLabelType);

                try {
                    notifyListeners(context.getResources().getString(R.string.capacitor_scan_event_name), ret);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught: ", e);
                }
            }
        }
    };

}
