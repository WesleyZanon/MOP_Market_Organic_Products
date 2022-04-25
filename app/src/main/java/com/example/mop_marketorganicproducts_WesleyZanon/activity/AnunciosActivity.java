package com.example.mop_marketorganicproducts_WesleyZanon.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;


import com.example.mop_marketorganicproducts_WesleyZanon.R;
import com.example.mop_marketorganicproducts_WesleyZanon.helper.configuracaoFireBase;

import com.google.firebase.auth.FirebaseAuth;



public class AnunciosActivity extends AppCompatActivity {

    private FirebaseAuth  autenticacao =  configuracaoFireBase.getReferenciaAutenticacao();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        //autenticacao.signOut();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(autenticacao.getCurrentUser() == null){ //caso usuario nao esteja cadastrado
            menu.setGroupVisible(R.id.group_deslogado, true); //exibir grupo para deslogado

        }else{
            menu.setGroupVisible(R.id.group_logado, true); //exibir grupo de usuario logado
        }


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_cadastrar:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

            case R.id.menu_sair:
                autenticacao.signOut();
                invalidateOptionsMenu();
                break;

            case R.id.menu_anuncios:
                startActivity(new Intent(getApplicationContext(), MeusAnunciosActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}