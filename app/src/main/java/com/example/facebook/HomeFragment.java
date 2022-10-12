package com.example.facebook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

     RecyclerView recyclerView;
     PostAdapter postAdapter;
     ArrayList<PostData> postData = new ArrayList<>();

    public HomeFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecycler(view);
    }

    private void setUpRecycler (View view){

        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));
        postData.add(new PostData(R.drawable.images,R.drawable.post_image,"Yasmine Issam","heellllooo"));

        recyclerView = view.findViewById(R.id.recycler_view);
        postAdapter = new PostAdapter(postData);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

    }
}