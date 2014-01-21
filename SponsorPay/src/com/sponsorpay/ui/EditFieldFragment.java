package com.sponsorpay.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sponsorpay.offer.R;

@SuppressLint("ValidFragment")
public class EditFieldFragment extends android.app.Fragment {

	
	private EditText inputEditField; 			//inputEditField field component 
	private TextView title_textview; 			//title_textview for input component 
	private TextView alertTextView; 	// alert appear only in case if input is required 
	
	
	private boolean  required; 			//required if it boolean requiredTextView is appear 
	private String titleString;   //title for title_textview
	
	
	/*
	 * @param boolean isrequired 
	 * @param String title
	 * brief constructor for EditFieldFragment
	 * */
	public EditFieldFragment(boolean isrequired,String title)
	{
		this.required=isrequired;
		this.titleString=title;
	}
	
	/*
	 * @param LayoutInflater inflater used to inflate the xml and convert it to View Class
	 * @param ViewGroup container 
	 * @param Bundle savedInstanceState
	 * 
	 *Brief load XML view and convert it View Object 
	 * */
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.editfieldlayout, container, false);
	}
	
	/*
	 * @param View view the generated View   
	 * @param Bundle savedInstanceState   
	 * 
	 *Brief Called once the view has been inflated and loaded to View Object 
	 * */
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		inputEditField=(EditText) view.findViewById(R.id.editfield);
		title_textview=(TextView) view.findViewById(R.id.title);
		alertTextView=(TextView) view.findViewById(R.id.requiredfield);
		
		title_textview.setText(titleString);
		if(required)
		{
			alertTextView.setText(titleString+" "+getString(R.string.fieldisrequired));
		}	
		
		
	}

	/*
	 * Brief validate if the input field is required 
	 * and view the Alert field 
	 * */
	
	public boolean isValid() {
		
		if(required&&inputEditField.getText().toString().isEmpty())
		{
			alertTextView.setVisibility(View.VISIBLE);
			return false;
		}
		else
		{
			alertTextView.setVisibility(View.INVISIBLE);
		return true;	
		}
		
		
	}

	/*
	 * @ brief return value of Input
	 * */
	
	public String getValue()
	{
		return inputEditField.getText().toString();
		
	}
	
	
}
