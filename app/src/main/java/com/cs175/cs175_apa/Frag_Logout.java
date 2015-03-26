package com.cs175.cs175_apa;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Sean Patrick T. Tan on 3/23/2015.
 */
public class Frag_Logout extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AlertDialog.Builder(getActivity())
                .setTitle("Confirm")
                .setMessage("Confirm log out?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent intent = new Intent(getActivity(), Login.class);
                        getActivity().startActivity(intent);
                        getActivity().finish();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }
}