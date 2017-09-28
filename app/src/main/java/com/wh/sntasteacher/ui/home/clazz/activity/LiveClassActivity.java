package com.wh.sntasteacher.ui.home.clazz.activity;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.alibaba.livecloud.live.AlivcMediaFormat;
import com.alibaba.livecloud.live.AlivcMediaRecorder;
import com.alibaba.livecloud.live.AlivcMediaRecorderFactory;
import com.alibaba.livecloud.live.AlivcStatusCode;
import com.alibaba.livecloud.live.OnLiveRecordErrorListener;
import com.alibaba.livecloud.live.OnNetworkStatusListener;
import com.alibaba.livecloud.live.OnRecordStatusListener;
import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.util.G;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class LiveClassActivity extends BaseActivity implements SurfaceHolder.Callback {


    /**
     * 直播画面
     */
    @BindView(R.id.surfaceView)
    SurfaceView mSurfaceView;
    /**
     * 直播承载画面
     */
    private SurfaceHolder mSurfaceHolder ;
    /**
     * 预览
     */
    private Surface mPreviewSurface;
    /**
     * 录制
     */
    private AlivcMediaRecorder mMediaRecorder;
    /**
     * 预览图的宽度
     */
    private int mPreviewWdith;
    /**
     * 预览图的高度
     */
    private int mPreviewHeight;
    /**
     * 预览的配置
     */
    private Map<String, Object> mConfigure = new HashMap<>();
    /**
     * 照相机的摄像头(前置/后置)
     */
    private int cameraFrontFacing;
    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setTitle("直播");
        setLeftImage(R.mipmap.ic_back);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mPreviewSurface = mSurfaceHolder.getSurface();
        mMediaRecorder =  AlivcMediaRecorderFactory.createMediaRecorder();
        mMediaRecorder.init(this);
        mMediaRecorder.setOnRecordStatusListener(mRecordStatusListener);
        mMediaRecorder.setOnNetworkStatusListener(mOnNetworkStatusListener);
        mMediaRecorder.setOnRecordErrorListener(mOnErrorListener);

    //    mConfigure.put(AlivcMediaFormat.KEY_CAMERA_FACING, cameraFrontFacing);
        mConfigure.put(AlivcMediaFormat.KEY_MAX_ZOOM_LEVEL, 3);
    //    mConfigure.put(AlivcMediaFormat.KEY_OUTPUT_RESOLUTION, resolution);
        mMediaRecorder.prepare(mConfigure, mPreviewSurface);
        mConfigure.put(AlivcMediaFormat.KEY_FRAME_RATE, 25);                                             //配置帧率
        mConfigure.put(AlivcMediaFormat.KEY_OUTPUT_RESOLUTION, AlivcMediaFormat.OUTPUT_RESOLUTION_480P); //配置分辨率
        mConfigure.put(AlivcMediaFormat.KEY_MAX_VIDEO_BITRATE, 500000);                                  //配置码率 500kbps
        mConfigure.put(AlivcMediaFormat.KEY_INITIAL_VIDEO_BITRATE, 500000);                              //配置码率 500kbps
        mMediaRecorder.prepare(mConfigure, mPreviewSurface);
        mMediaRecorder.startRecord("");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_live_class;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        holder.setKeepScreenOn(true);
        mPreviewSurface = holder.getSurface();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mMediaRecorder.setPreviewSize(width, height);
        mPreviewWdith = width;
        mPreviewHeight  = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mPreviewSurface = null;
        mMediaRecorder.stopRecord();
        mMediaRecorder.reset();
    }
    private OnRecordStatusListener  mRecordStatusListener = new OnRecordStatusListener(){

        @Override
        public void onDeviceAttach() {

        }

        @Override
        public void onDeviceAttachFailed(int i) {

        }

        @Override
        public void onSessionAttach() {

        }

        @Override
        public void onSessionDetach() {

        }

        @Override
        public void onDeviceDetach() {

        }

        @Override
        public void onIllegalOutputResolution() {

        }
    };
    private OnNetworkStatusListener mOnNetworkStatusListener = new OnNetworkStatusListener() {
        @Override
        public void onNetworkBusy() {

        }

        @Override
        public void onNetworkFree() {

        }

        @Override
        public void onConnectionStatusChange(int i) {

        }

        @Override
        public boolean onNetworkReconnectFailed() {
            return false;
        }
    };
    private OnLiveRecordErrorListener mOnErrorListener =  new OnLiveRecordErrorListener() {
        @Override
        public void onError(int errorCode) {
            switch (errorCode) {
                case AlivcStatusCode.ERROR_SERVER_CLOSED_CONNECTION:
                case AlivcStatusCode.ERORR_OUT_OF_MEMORY:
                case AlivcStatusCode.ERROR_CONNECTION_TIMEOUT:
                case AlivcStatusCode.ERROR_BROKEN_PIPE:
                case AlivcStatusCode.ERROR_ILLEGAL_ARGUMENT:
                case AlivcStatusCode.ERROR_IO:
                case AlivcStatusCode.ERROR_NETWORK_UNREACHABLE:
                  G.log("Live stream connection error-->" + errorCode);
                    G.showToast(getApplicationContext(),"Live stream connection error-->" + errorCode);
                    break;
                default:
            }
        }
    };
}
