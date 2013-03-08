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

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MifflinRMRActivity extends Activity implements OnClickListener {

	// widget references
	private AdView adView;
	private Button btnCalcRMR;
	private EditText txtWeight, txtAge, txtHeight, txtRMR;
	private Double weight, age, height, mifflinRMR;
	private CheckBox chkFemale;
	private Boolean female;
	private LinearLayout layoutBackground;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mifflinrmr);

		// AdManager.setTestDevices( new String[] {
		// AdManager.TEST_EMULATOR, // Android emulator
		// "015A8A3C1501A002", // My Droid X ID
		// });

		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();

		btnCalcRMR = (Button) findViewById(R.id.btnCalcRMR);
		txtWeight = (EditText) findViewById(R.id.txtWeight);
		txtHeight = (EditText) findViewById(R.id.txtHeight);
		txtAge = (EditText) findViewById(R.id.txtAge);
		txtRMR = (EditText) findViewById(R.id.txtRMR);
		chkFemale = (CheckBox) findViewById(R.id.chkFemale);
		layoutBackground = (LinearLayout) findViewById(R.id.layoutBackground);
		layoutBackground.setOnClickListener(this);
		btnCalcRMR.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View arg0) {

		Context context = getApplicationContext();
		CharSequence text = "Invalid Data";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);

		// TODO Auto-generated method stub
		if (arg0 == btnCalcRMR) {

			try {
				weight = Double.valueOf(txtWeight.getText().toString());
				height = Double.valueOf(txtHeight.getText().toString());
				age = Double.valueOf(txtAge.getText().toString());
			} catch (Exception e) {
				toast.show();
				weight = 1.0;
				height = 10.0;
				age = 10.0;

				txtWeight.setText(Double.toString(weight),
						TextView.BufferType.EDITABLE);
				txtHeight.setText(Double.toString(height),
						TextView.BufferType.EDITABLE);
				txtAge.setText(Double.toString(age),
						TextView.BufferType.EDITABLE);
			}

			female = chkFemale.isChecked();

			if (!female) {
				mifflinRMR = (10.0 * weight * 0.4535924 + 6.25 * height * 2.54
						- 5 * age + 5);
			} else {
				mifflinRMR = (10.0 * weight * 0.4535924 + 6.25 * height * 2.54
						- 5 * age - 161);
			}

			txtRMR.setText(Double.toString(mifflinRMR),
					TextView.BufferType.NORMAL);

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
