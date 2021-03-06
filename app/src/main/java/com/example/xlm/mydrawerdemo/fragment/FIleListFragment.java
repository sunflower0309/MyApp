package com.example.xlm.mydrawerdemo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xlm.mydrawerdemo.R;
import com.example.xlm.mydrawerdemo.adapter.FileListAdapter;
import com.example.xlm.mydrawerdemo.adapter.OnItemClickListenr;
import com.example.xlm.mydrawerdemo.base.BaseDialogFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏祺 on 2017/6/30.
 */
@SuppressLint("ValidFragment")
public class FIleListFragment extends BaseDialogFragment {
    View rootView;
    private RecyclerView rvFileList;
    private FileListAdapter mAdapter;
    private List<File> listFiles = new ArrayList<>();
    private OnFileClickListener onFileClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_file_list, null);
        }
        return rootView;
    }

    public FIleListFragment(File[] files, OnFileClickListener onFileClickListener) {
        this.onFileClickListener = onFileClickListener;
        if (null == files)
            return;
        for (int i = 0; i < files.length; i++) {
            listFiles.add(files[i]);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        rvFileList = (RecyclerView) view.findViewById(R.id.rv_file_list);
    }

    private void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new FileListAdapter(listFiles, onItemClickListenr);
        rvFileList.setLayoutManager(layoutManager);
        rvFileList.setAdapter(mAdapter);
    }

    private OnItemClickListenr onItemClickListenr = new OnItemClickListenr() {
        @Override
        public void onItemClick(View view, int position) {
            if (null != onFileClickListener) {
                onFileClickListener.onClick(listFiles.get(position));
            }
        }
    };

    public interface OnFileClickListener {
        void onClick(File file);
    }
}
