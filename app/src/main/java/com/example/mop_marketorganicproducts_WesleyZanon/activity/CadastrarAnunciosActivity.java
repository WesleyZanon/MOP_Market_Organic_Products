package com.example.mop_marketorganicproducts_WesleyZanon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mop_marketorganicproducts_WesleyZanon.R;
import com.example.mop_marketorganicproducts_WesleyZanon.helper.configuracaoFireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import android.view.View;

import java.util.Currency;
import java.util.Locale;


public class CadastrarAnunciosActivity extends AppCompatActivity {

    private EditText campoTitulo, campoDescricao;
    private EditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anuncios);

        inicializarComponentes();

    }

        public void salvarAnuncio(View view){

            String  valor = campoValor.getText().toString();
            Log.d("Salvar","Salvar Anuncio"+valor);
        }




    private void inicializarComponentes(){

        campoTitulo = findViewById(R.id.EditTituloProduto);
        campoValor = findViewById(R.id.EditValorProduto);
        campoDescricao = findViewById(R.id.EditTituloProduto);

        Locale locale = new Locale("pt", "BR");

    }
}