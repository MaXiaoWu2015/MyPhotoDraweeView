package me.relex.photodraweeview.sample;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import me.relex.photodraweeview.PhotoDraweeView;

public class ForViewpagerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private PhotoDraweeView mPhotoDraweeView;
    private int[] mDrawables = new int[] {
            R.drawable.viewpager_1, R.drawable.viewpager_2, R.drawable.viewpager_3
    };
    public ForViewpagerFragment() {
        // Required empty public constructor
    }
    public static ForViewpagerFragment newInstance() {
        ForViewpagerFragment fragment = new ForViewpagerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_for_viewpager, container, false);
        mPhotoDraweeView= (PhotoDraweeView) view.findViewById(R.id.pdv_pic);
        PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
//        controller.setUri(Uri.parse("res:///" + mDrawables[1]));
        Uri uri =Uri.parse("res:///" + mDrawables[1]);
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri).setResizeOptions(
                new ResizeOptions(4096, 4096));
        ImageRequest request=builder.build();
        controller.setOldController(mPhotoDraweeView.getController());
        controller.setImageRequest(request);
        controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo == null) {
                    return;
                }
                mPhotoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
            }
        });
        mPhotoDraweeView.setController(controller.build());
        return view;
    }

}
