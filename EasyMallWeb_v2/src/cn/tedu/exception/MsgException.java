package cn.tedu.exception;

public class MsgException extends RuntimeException
{
	public MsgException()
	{
		super();
	}

	public MsgException(String msg)
	{
		super(msg);
	}
}
