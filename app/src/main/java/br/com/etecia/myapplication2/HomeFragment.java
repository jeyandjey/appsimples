package br.com.etecia.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class HomeFragment extends AppCompatActivity {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }
}
public class ExemploFragment extends Fragment {
    private static final String ARG_TEXT = "arg_text";
    private String texto;

    public static ExemploFragment newInstance(String texto) {
        ExemploFragment f = new ExemploFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, texto);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            texto = getArguments().getString(ARG_TEXT);
        }
    }

    public interface OnBabyTalk {
    }
    // onCreateView / onViewCreated ...
}

public class ExemploFragment extends Fragment {
    public interface OnBabyTalk {
        void onBabySays(String msg);
    }
    private OnBabyTalk callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnBabyTalk) {
            callback = (OnBabyTalk) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnBabyTalk");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    // quando quiser avisar a Activity:
    private void avisarActivity() {
        if (callback != null) callback.onBabySays("Preciso de atenção!");
    }
}