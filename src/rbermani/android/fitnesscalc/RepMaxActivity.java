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
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RepMaxActivity extends Activity implements OnClickListener{
	
	// widget references
	private AdView adView;
	private Button btnCalcRepMax;
	private EditText txtWeightLifted,txtNumberReps,txtOneRepMax;
	private double weightLifted, numberReps, oneRepMax;
	private LinearLayout layoutBackground;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onerepmax);
        
        
		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();
        
        btnCalcRepMax = (Button) findViewById(R.id.btnCalcRepMax);
        txtWeightLifted = (EditText) findViewById(R.id.txtWeightLifted);
        txtNumberReps = (EditText) findViewById(R.id.txtNumberReps);
        txtOneRepMax = (EditText) findViewById(R.id.txtOneRepMax);
        
        btnCalcRepMax.setOnClickListener(this);
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
		
		if (arg0 == btnCalcRepMax){
			try {
			weightLifted = Double.valueOf(txtWeightLifted.getText().toString());
			numberReps = Double.valueOf(txtNumberReps.getText().toString());
			oneRepMax = weightLifted / (1.0278 - (0.0278 * numberReps));
			} catch (Exception e){
				toast.show();
				txtWeightLifted.setText(Double.toString(0.0),TextView.BufferType.EDITABLE);
				txtNumberReps.setText(Double.toString(0.0),TextView.BufferType.EDITABLE);
				weightLifted = 1;
				numberReps = 1;
				oneRepMax = weightLifted / (1.0278 - (0.0278 * numberReps));
			}
			txtOneRepMax.setText(Double.toString(oneRepMax),TextView.BufferType.NORMAL);
		
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
}
}
