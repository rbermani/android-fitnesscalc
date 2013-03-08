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

public class CreatineActivity extends Activity implements OnClickListener{
	
	// widget references
	private AdView adView;
	private EditText txtBodyWeight, txtWeekOne, txtWeekTwo, txtWeekFive;
	private LinearLayout layoutBackground;
	private Button btnCalcCreatine;
	private Double bodyWeight;
	private Double weekOne, weekTwo, weekFive;

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatineconsume);
        
        
        adView = (AdView) findViewById(R.id.ad);
        adView.requestFreshAd();
        
        btnCalcCreatine = (Button) findViewById(R.id.btnCalcCreatine);
        txtBodyWeight = (EditText) findViewById(R.id.txtBodyWeight);
        txtWeekOne = (EditText)findViewById(R.id.txtWeekOne);
        txtWeekTwo = (EditText)findViewById(R.id.txtWeekTwo);
        txtWeekFive = (EditText)findViewById(R.id.txtWeekFive);
        
        btnCalcCreatine.setOnClickListener(this);
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
		
		if (arg0 == btnCalcCreatine){
			try {
			bodyWeight = Double.valueOf(txtBodyWeight.getText().toString());
			} catch (Exception e) {
				toast.show();
				bodyWeight = 10.0;
			}
			weekOne = bodyWeight / 6.2887;
			
			weekTwo = bodyWeight / 14.683;
			
			txtWeekOne.setText(Double.toString(weekOne),TextView.BufferType.NORMAL);
			txtWeekTwo.setText(Double.toString(weekTwo), TextView.BufferType.NORMAL);
			txtWeekFive.setText("Cycle off.");
			
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
