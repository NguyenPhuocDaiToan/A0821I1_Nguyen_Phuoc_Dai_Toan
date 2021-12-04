package ss15_Exception_Debug.BaiTap;

public class IllegalTriangleException extends RuntimeException{
    public IllegalTriangleException(String errorMessage) {
        super(errorMessage);
    }
}
