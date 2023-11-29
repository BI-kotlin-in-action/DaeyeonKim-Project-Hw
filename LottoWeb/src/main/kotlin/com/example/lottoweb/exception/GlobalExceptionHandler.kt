import com.example.lottoweb.service.MyException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MyException::class)
    fun handleMyException(e: MyException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.valueOf(e.code))
    }
}
