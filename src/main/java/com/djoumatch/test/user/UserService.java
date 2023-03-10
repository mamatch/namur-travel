package com.djoumatch.test.user;

import com.djoumatch.test.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByNumber(String number) {
        return userRepository.getUserByContact(number)
                .orElseThrow(() -> new NotFoundException());
    }
}
