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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RMRSelectActivity extends Activity implements OnClickListener{
	
	// widget references
	private AdView adView;
	private Button btnMifflin, btnCunningham;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rmrselect);
        
		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();
		
        btnMifflin = (Button) findViewById(R.id.btnMifflin);
        btnCunningham = (Button) findViewById(R.id.btnCunningham);
        
        
        btnMifflin.setOnClickListener(this);
        btnCunningham.setOnClickListener(this);
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0 == btnMifflin){
			Intent MifflinRMRActivity = new Intent(getBaseContext(),
					MifflinRMRActivity.class);
			
			startActivity(MifflinRMRActivity);
			
		} else if (arg0 == btnCunningham){
			Intent RMRCalcActivity = new Intent(getBaseContext(),
					RMRCalcActivity.class);
			
			startActivity(RMRCalcActivity);
		} 
		
	}
}

