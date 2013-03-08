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

public class MacroActivity extends Activity implements OnClickListener{
	
	// widget references
	private AdView adView;
	private Button btnCalcMacro;
	private EditText txtBodyWeight, txtCalories, txtProtein, txtCarbs, txtFats;
	private Double bodyWeight, cals1, cals2, carbs1, carbs2, fats1, fats2, protein1, protein2;
	private LinearLayout layoutBackground;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macronutrient);
        
        
        adView = (AdView) findViewById(R.id.ad);
        
        btnCalcMacro = (Button) findViewById(R.id.btnCalcMacro);
        txtBodyWeight = (EditText) findViewById(R.id.txtBodyWeight);
        txtCalories = (EditText)findViewById(R.id.txtCalories);
        txtProtein = (EditText)findViewById(R.id.txtProtein);
        txtCarbs = (EditText) findViewById(R.id.txtCarbs);
        txtFats = (EditText)findViewById(R.id.txtFats);
        
        btnCalcMacro.setOnClickListener(this);
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
		
		
		if (arg0 == btnCalcMacro){
			try {
				bodyWeight = Double.valueOf(txtBodyWeight.getText().toString());
			} catch (Exception e) {
				toast.show();
				bodyWeight = 100.0;
				
			}
				cals1 = bodyWeight * 12.0;
				cals2 = bodyWeight * 14.0;
				protein1 = bodyWeight * 1.05;
				protein2 = bodyWeight * 1.2250;
				fats1 = bodyWeight * 0.2666;
				fats2 = bodyWeight * 0.3111;
				carbs1 = bodyWeight * 1.35;
				carbs2 = bodyWeight * 1.5750;
				
				txtCalories.setText(Double.toString(cals1) + " - " + Double.toString(cals2),TextView.BufferType.NORMAL);
				txtProtein.setText(Double.toString(protein1) + " - " + Double.toString(protein2),TextView.BufferType.NORMAL);
				txtFats.setText(Double.toString(fats1) + " - " + Double.toString(fats2),TextView.BufferType.NORMAL);
				txtCarbs.setText(Double.toString(carbs1) + " - " + Double.toString(carbs2),TextView.BufferType.NORMAL);
				
		
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
