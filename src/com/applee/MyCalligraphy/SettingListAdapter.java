package com.applee.MyCalligraphy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SettingListAdapter extends BaseAdapter
{

		@Override
		public int getCount()
		{
				// TODO Auto-generated method stub
				return 0;
		}

		@Override
		public Object getItem(int arg0)
		{
				// TODO Auto-generated method stub
				return null;
		}

		@Override
		public long getItemId(int arg0)
		{
				// TODO Auto-generated method stub
				return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2)
		{
				// TODO Auto-generated method stub
				return null;
		}
//		private List<Map<String, Object>> mData;
//		private LayoutInflater mInflater;
//		public SettingListAdapter(Context context)
//		{
//				this.mInflater = LayoutInflater.from(context);
//		}
//
//		@Override
//		public int getCount()
//		{
//				// TODO Auto-generated method stub
//				return mData.size();
//		}
//
//		@Override
//		public Object getItem(int arg0)
//		{
//				// TODO Auto-generated method stub
//				return null;
//		}
//
//		@Override
//		public long getItemId(int arg0)
//		{
//				// TODO Auto-generated method stub
//				return 0;
//		}
//
//		@Override
//		public View getView(int arg0, View arg1, ViewGroup arg2)
//		{
//				// TODO Auto-generated method stub
//				View convertView = null;
//				SettingViewHolder holder = null;
//				if (convertView == null)
//				{
//
//						holder = new SettingViewHolder();
//
//						convertView = mInflater.inflate(
//										R.layout.settinglistview, null);
//						holder.img = (ImageView) convertView
//										.findViewById(R.id.img);
//						holder.title = (TextView) convertView
//										.findViewById(R.id.title);
//						holder.info = (TextView) convertView
//										.findViewById(R.id.info);
//						holder.viewBtn = (Button) convertView
//										.findViewById(R.id.view_btn);
//						convertView.setTag(holder);
//
//				}
//				else
//				{
//
//						holder = (SettingViewHolder) convertView.getTag();
//				}
//
//				holder.img.setBackgroundResource((Integer) mData.get(
//								position).get("img"));
//				holder.title.setText((String) mData.get(position).get(
//								"title"));
//				holder.info.setText((String) mData.get(position).get(
//								"info"));
//
//				holder.viewBtn.setOnClickListener(new View.OnClickListener()
//				{
//
//						@Override
//						public void onClick(View v)
//						{
//								showInfo();
//						}
//				});
//
//				return convertView;
//		}
}
