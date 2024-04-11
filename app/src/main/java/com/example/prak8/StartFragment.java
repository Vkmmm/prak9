package com.example.prak8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class StartFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        EditText editTextRecipients = view.findViewById(R.id.recipients);
        EditText editTextSubject = view.findViewById(R.id.subject);
        EditText editTextText = view.findViewById(R.id.text);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipients = editTextRecipients.getText().toString();
                String subject = editTextSubject.getText().toString();
                String text = editTextText.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {recipients});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, text);
                Uri.parse("content://path/to/email/attachment");
                // Создаем диалог выбора приложения для отправки сообщения
                startActivity(Intent.createChooser(emailIntent, "Отправить через"));
            }
        });
        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_photoFragment);
            }
        });

        return view;}

}