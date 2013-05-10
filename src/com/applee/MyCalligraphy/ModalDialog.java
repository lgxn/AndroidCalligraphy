package com.applee.MyCalligraphy;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;

/**
 * 
 * @author admin
 */
public class ModalDialog extends Dialog
{
		boolean m_Exit_By_OK = false;// 对话框返回方式
		Handler m_Handler = null;// 消息句柄
		int m_nLayoutID = 0;// 对话框布局ID
		View m_View = null;// 对话框视图
		Activity m_owner = null;

		public ModalDialog(Activity context, int nLayoutID)
		{
				super(context);
				m_Exit_By_OK = false;
				m_nLayoutID = nLayoutID;
				m_owner = context;
				setOwnerActivity(context);
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				m_View = context.getLayoutInflater().inflate(nLayoutID, null);
				setContentView(m_View);
				onInitDialog();
		}

		// 退回键按下响应
		@Override
		public void onBackPressed()
		{
				super.onBackPressed();
				onCancel();
		}

		// 对话框初始化
		public void onInitDialog()
		{
		}

		// 显示模态对话框
		public boolean doModal()
		{
				m_Handler = new Handler()
				{
						@Override
						public void handleMessage(Message mesg)
						{
								// process incoming messages here
								// super.handleMessage(msg);
								throw new RuntimeException();
						}
				};
				super.show();
				try
				{
						Looper.getMainLooper().loop();
				}
				catch (RuntimeException e2)
				{
				}
				return m_Exit_By_OK;
		}

		// 退出对话框
		public void onOk()
		{
				this.m_Exit_By_OK = true;
				dismiss();
				Message m = m_Handler.obtainMessage();
				m_Handler.sendMessage(m);
		}

		// 退出对话框
		public void onCancel()
		{
				this.m_Exit_By_OK = false;
				dismiss();
				Message m = m_Handler.obtainMessage();
				m_Handler.sendMessage(m);
		}

		// //////////////////////////////////////////////////////////////////////////
		// 设置视图文本
		private boolean setViewText(View v, Object title)
		{
				String strTitle = title.toString();
				if (null == v)
						return false;
				if (null == strTitle)
						strTitle = "";
				try
				{
						Class ownerClass = v.getClass();
						Class[] argsClass = {CharSequence.class};
						Method method = ownerClass.getMethod("setText",
										argsClass);
						Object[] args = {strTitle};
						method.invoke(v, args);
				}
				catch (Exception e)
				{
						return false;
				}

				return true;
		}

		// 取得视图文本
		private String getViewText(View v)
		{
				if (null == v)
						return null;
				try
				{
						Class ownerClass = v.getClass();
						Class[] argsClass = {};
						Method method = ownerClass.getMethod("getText",
										argsClass);
						Object[] args = {};
						return method.invoke(v, args).toString();
				}
				catch (Exception e)
				{
						return null;
				}
		}

		// //////////////////////////////////////////////////////////////////////////
		// 标题控件方法
		// 取得资源
		protected View getTitleCtrl(int nID)
		{
				return findViewById(nID);
		}

		// 设置控件文本
		protected String getTitleCtrlText(int nID)
		{
				View v = getTitleCtrl(nID);
				return getViewText(v);
		}

		// 设置控件标题
		protected boolean setTitleCtrlText(int nID, Object title)
		{
				View v = getTitleCtrl(nID);
				return setViewText(v, title);
		}

		// //////////////////////////////////////////////////////////////////////////
		// 对话框控件
		// 取得资源
		protected View getCtrl(int nID)
		{
				return m_View.findViewById(nID);
		}

		// 设置控件文本
		protected String getCtrlText(int nID)
		{
				View v = getCtrl(nID);
				return getViewText(v);
		}

		// 设置控件文本
		protected boolean setCtrlText(int nID, Object title)
		{
				View v = getCtrl(nID);
				return setViewText(v, title);
		}

}
