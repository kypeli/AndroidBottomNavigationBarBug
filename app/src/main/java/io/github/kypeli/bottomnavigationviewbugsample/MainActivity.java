package io.github.kypeli.bottomnavigationviewbugsample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum NaviItems {
        DOG("Dog", R.id.action_dog),
        CAT("Cat", R.id.action_cat),
        FISH("Fish", R.id.action_fish),
        COW("Cow", R.id.action_cow),
        PARROT("Parrot", R.id.action_parrot);

        public final String naviAnimal;
        private final int id;

        NaviItems(String animal, @IdRes int id) {
            this.naviAnimal = animal;
            this.id = id;
        }
    }

    private NaviItems selectedNaviPage;
    private BottomNavigationView bottomNavigation;
    private TextView selectedAnimal;
    private Button prevButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        selectedAnimal = (TextView) findViewById(R.id.animal);
        prevButton = (Button) findViewById(R.id.prev_button);
        nextButton = (Button) findViewById(R.id.next_button);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_dog:
                        pageSelected(NaviItems.DOG);
                        break;
                    case R.id.action_cat:
                        pageSelected(NaviItems.CAT);
                        break;
                    case R.id.action_fish:
                        pageSelected(NaviItems.FISH);
                        break;
                    case R.id.action_cow:
                        pageSelected(NaviItems.COW);
                        break;
                    case R.id.action_parrot:
                        pageSelected(NaviItems.PARROT);
                        break;
                }
                return true;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedNaviPage.ordinal() + 1 <= (NaviItems.values().length - 1)) {
                    int nextIndex = selectedNaviPage.ordinal() + 1;
                    NaviItems item = NaviItems.values()[nextIndex];
                    pageSelected(item);
                    programaticallyNavigateTo(item);
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedNaviPage.ordinal() - 1 >= 0) {
                    int prevIndex = selectedNaviPage.ordinal()-1;
                    NaviItems item = NaviItems.values()[prevIndex];
                    pageSelected(item);
                    programaticallyNavigateTo(item);
                }
            }
        });

        pageSelected(NaviItems.DOG);
    }

    private void pageSelected(NaviItems navi) {
        selectedNaviPage = navi;
        selectedAnimal.setText(navi.naviAnimal);
    }

    private void programaticallyNavigateTo(NaviItems item) {
        bottomNavigation.getMenu().getItem(item.ordinal()).setChecked(true);
    }
}
