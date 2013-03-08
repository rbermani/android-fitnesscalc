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

public class RepTargetActivity extends Activity implements OnClickListener{

	// widget references
	private AdView adView;
	private EditText txtOneRepMax,txtTargetWeight,txtRepsPossible;
	private Button btnCalcRepsPossible;
	private Double oneRepMax,targetWeight,RepsPossible;
	private LinearLayout layoutBackground;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repattarget);


		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();

		txtOneRepMax = (EditText) findViewById(R.id.txtOneRepMax);
		txtTargetWeight = (EditText) findViewById(R.id.txtTargetWeight);
		txtRepsPossible = (EditText) findViewById(R.id.txtRepsPossible);
		btnCalcRepsPossible = (Button) findViewById(R.id.btnCalcRepsPossible);

		btnCalcRepsPossible.setOnClickListener(this);
		layoutBackground = (LinearLayout) findViewById(R.id.layoutBackground);
		layoutBackground.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		
		Context context = getApplicationContext();
		CharSequence text = "Invalid Data";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		
		
		// TODO Auto-generated method stub
		if (arg0 == btnCalcRepsPossible){
			try {
				oneRepMax = Double.valueOf(txtOneRepMax.getText().toString());
				targetWeight = Double.valueOf(txtTargetWeight.getText().toString());
			} catch (Exception e) {
				
				toast.show();
				oneRepMax = 1.0;
				targetWeight = 1.0;
				
				txtOneRepMax.setText(Double.toString(oneRepMax), TextView.BufferType.EDITABLE);
				txtTargetWeight.setText(Double.toString(targetWeight), TextView.BufferType.EDITABLE);
			}
			
			RepsPossible = ((targetWeight / oneRepMax) - 1.0278)/ (-0.0278);
			RepsPossible = (double) Math.round(RepsPossible);
			txtRepsPossible.setText(Double.toString(RepsPossible), TextView.BufferType.NORMAL);

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
