package com.zyj.redis.bean;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    String userId;

    String userName;
}
