package com.daniilk.la5cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {


    private static final String EXTRA_NAME = "name";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_DRINK_TYPE = "drink_type";

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewDrinkType;
    private TextView textViewAdditives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        // Самостоятельно установить данные
        initViews();
        Intent intent = getIntent();
        textViewName.setText(intent.getStringExtra(EXTRA_NAME));
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK));
        textViewDrinkType.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        textViewAdditives.setText(intent.getStringExtra(EXTRA_ADDITIVES));
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditives);
    }

    public static Intent newIntent(
            Context context,
            String name,
            String drink,
            String additives,
            String drinkType
    ) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);

        return intent;
    }
}