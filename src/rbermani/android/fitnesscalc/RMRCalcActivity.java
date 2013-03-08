/*******************************************************************************
 * Copyright (c) 2010 Robert Bermani.
 * All rights reserved. This program and its accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which is included with this distribution and available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Robert Bermani - initial API and implementation
 ******************************************************************************/
package rbermani.android.fitnesscalc;

import com.admob.android.ads.AdView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RMRCalcActivity extends Activity implements OnClickListener{

	// widget references
	private AdView adView;
	private Button btnCalcRMR;
	private EditText txtLBM, txtRMR;
	private Double LBM, RMR;
	private LinearLayout layoutBackground;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rmrcalc);

        adView = (AdView) findViewById(R.id.ad);
        adView.requestFreshAd();
        

		btnCalcRMR = (Button) findViewById(R.id.btnCalcRMR);
		txtLBM = (EditText) findViewById(R.id.txtLBM);
		txtRMR = (EditText) findViewById(R.id.txtRMR);

		btnCalcRMR.setOnClickListener(this);
		layoutBackground = (LinearLayout) findViewById(R.id.layoutBackground);
		layoutBackground.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Context context = getApplicationContext();
		CharSequence text = "Invalid Data";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		
		if (arg0 == btnCalcRMR){
			try {
			LBM = Double.valueOf(txtLBM.getText().toString());
			} catch (Exception e){

				toast.show();
				txtLBM.setText(Double.toString(0.0),TextView.BufferType.EDITABLE);
				LBM = 0.0;
			}
			
			RMR = 500 + (22*LBM);
			txtRMR.setText(Double.toString(RMR),TextView.BufferType.NORMAL);
		} else if (arg0 == layoutBackground) {
			View currentView = this.getCurrentFocus();
			if (currentView != null) {
				InputMethodManager inputManager = (InputMethodManager) context
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				inputManager.hideSoftInputFromWindow(
						currentView.getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
	}
}
}
