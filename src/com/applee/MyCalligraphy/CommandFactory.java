package com.applee.MyCalligraphy;

public class CommandFactory
{
		public enum CommandType
		{
				REFRESH, SETTING
		};

		public static Command mCommand = null;

		public static Command createCommand(CommandType type)
		{
				// Command mCommand = null;
				switch (type)
				{
						case SETTING :
								mCommand = new SettingCommand();
								break;
						case REFRESH :
								mCommand = new RefreshCommand();
								break;
						default :
								break;
				}

				return mCommand;
		}

		public static Command getCurrentCommand()
						throws IllegalArgumentException
		{
				if (mCommand == null)
						throw new IllegalArgumentException(
										"command is not initialized.");

				return mCommand;
		}
}
