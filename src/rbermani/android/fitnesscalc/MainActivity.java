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
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	// widget references
	private AdView adView;
	private Button btnRepMax, btnRepsPossible, btnLBM, btnRMR, btnCreatine,
	btnVO2, btnMacroNutr, btnWaterIntake;



	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {

		case R.id.about:
			Intent aboutActivity = new Intent(getBaseContext(),
					AboutActivity.class);

			startActivity(aboutActivity);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//		AdManager.setTestDevices(new String[] { AdManager.TEST_EMULATOR, // Android
		//																			// emulator
		//				"015A8A3C1501A002", // My Droid X ID
		//		});

		adView = (AdView) findViewById(R.id.ad);
		adView.requestFreshAd();

		btnRepMax = (Button) findViewById(R.id.btnRepMax);
		btnRepsPossible = (Button) findViewById(R.id.btnRepsPossible);
		btnLBM = (Button) findViewById(R.id.btnLBM);
		btnRMR = (Button) findViewById(R.id.btnRMR);
		btnCreatine = (Button) findViewById(R.id.btnCreatine);
		btnVO2 = (Button) findViewById(R.id.btnVO2);
		btnMacroNutr = (Button) findViewById(R.id.btnMacroNutr);
		btnWaterIntake = (Button) findViewById(R.id.btnWaterIntake);

		btnRepMax.setOnClickListener(this);
		btnRepsPossible.setOnClickListener(this);
		btnLBM.setOnClickListener(this);
		btnRMR.setOnClickListener(this);
		btnCreatine.setOnClickListener(this);
		btnVO2.setOnClickListener(this);
		btnMacroNutr.setOnClickListener(this);
		btnWaterIntake.setOnClickListener(this);

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0 == btnRepMax) {
			Intent repMaxActivity = new Intent(getBaseContext(),
					RepMaxActivity.class);

			startActivity(repMaxActivity);

		} else if (arg0 == btnRepsPossible) {
			Intent repTargetActivity = new Intent(getBaseContext(),
					RepTargetActivity.class);

			startActivity(repTargetActivity);

		} else if (arg0 == btnLBM) {
			Intent lbmActivity = new Intent(getBaseContext(), LBMActivity.class);

			startActivity(lbmActivity);
		} else if (arg0 == btnRMR) {
			Intent rmrSelectActivity = new Intent(getBaseContext(),
					RMRSelectActivity.class);

			startActivity(rmrSelectActivity);
		} else if (arg0 == btnCreatine) {
			Intent creatineActivity = new Intent(getBaseContext(),
					CreatineActivity.class);

			startActivity(creatineActivity);
		} else if (arg0 == btnVO2) {
			Intent vo2MaxActivity = new Intent(getBaseContext(),
					VO2MaxActivity.class);

			startActivity(vo2MaxActivity);
		}  else if (arg0 == btnMacroNutr) {
			Intent macroActivity = new Intent(getBaseContext(),
					MacroActivity.class);

			startActivity(macroActivity);
		} else if (arg0 == btnWaterIntake) {
			Intent waterIntakeActivity = new Intent(getBaseContext(),
					WaterIntakeActivity.class);

			startActivity(waterIntakeActivity);

		}

	}


}
