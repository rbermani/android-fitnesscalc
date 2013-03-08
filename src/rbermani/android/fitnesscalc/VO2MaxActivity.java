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

public class VO2MaxActivity extends Activity implements OnClickListener {

	// widget references
	private AdView adView;
	private Button btnCalcVO2;
	private EditText txtDistanceRun, txtTimeRun, txtVO2Max;
	private double v, vo2, vo2max, distance, time, percentMax;
	private LinearLayout layoutBackground;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vo2max);

		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();

		btnCalcVO2 = (Button) findViewById(R.id.btnCalcVO2);

		txtDistanceRun = (EditText) findViewById(R.id.txtDistanceRun);
		txtTimeRun = (EditText) findViewById(R.id.txtTimeRun);

		txtVO2Max = (EditText) findViewById(R.id.txtVO2Max);
		
		btnCalcVO2.setOnClickListener(this);
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

		if (arg0 == btnCalcVO2) {

			try {
				distance = Double.valueOf(txtDistanceRun.getText().toString());
				time = Double.valueOf(txtTimeRun.getText().toString());

			} catch (Exception e) {
				toast.show();
				distance = 1.0;
				time = 4.0;
			}

			v = (distance * 1000.0) / time;

			percentMax = 0.8 + (0.1894393 * Math.exp(-0.012778 * time))
					+ (0.2989558 * Math.exp(-0.1932605 * time));
			vo2 = -4.60 + (0.182258 * v) + (0.000104 * v * v);
			vo2max = vo2 / percentMax;

			txtVO2Max.setText(Double.toString(vo2max),
					TextView.BufferType.NORMAL);

		}else if (arg0 == layoutBackground) {
			View currentView = this.getCurrentFocus();
			if (currentView != null) {
				InputMethodManager inputManager = (InputMethodManager) context
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				inputManager.hideSoftInputFromWindow(
						currentView.getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
	}
}}
