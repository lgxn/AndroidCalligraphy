package com.applee.MyCalligraphy;

import android.util.AndroidException;

enum CharacterBackgroundType
{
		RED_CHARACTER_BACKGROUND, COPY_CHARACTER_BACKGROUND
}

public class CharacterBackgroundFactory
{
		private static CharacterBackground mInstance = null;

		public static CharacterBackground getCharacterBackground(
						CharacterBackgroundType type) throws AndroidException
		{
				switch (type)
				{
						case RED_CHARACTER_BACKGROUND :
								mInstance = new RedCharacterBackground();
								break;
						case COPY_CHARACTER_BACKGROUND :
								mInstance = new CopyCharacterBackground();
								break;
						default :
								throw new AndroidException("Not Implement.");
				}

				return mInstance;
		}

		public static CharacterBackground getCurrentInstance()
		{
				// TODO Auto-generated method stub
				return mInstance;
		}
}
