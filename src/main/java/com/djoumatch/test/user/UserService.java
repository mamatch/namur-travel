package com.djoumatch.test.user;

import com.djoumatch.test.exception.NotFoundException;
import com.djoumatch.test.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByNumber(String number) {
        return userRepository.findByNumber(number)
                .orElseThrow(() -> new UserNotFoundException(number));
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
