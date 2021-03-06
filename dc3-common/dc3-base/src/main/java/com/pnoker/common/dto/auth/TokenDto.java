/*
 * Copyright 2019 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pnoker.common.dto.auth;

import com.pnoker.common.base.Converter;
import com.pnoker.common.bean.Pages;
import com.pnoker.common.entity.auth.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Token Dto
 *
 * @author : pnoker
 * @email : pnokers@icloud.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TokenDto implements Serializable, Converter<Token> {
    private static final long serialVersionUID = 1L;

    /**
     * Token令牌
     */
    @NotNull(message = "token can't be empty")
    private String token;

    /**
     * User编号
     */
    @NotNull(message = "user id can't be empty")
    private Long userId;

    private Pages page;

    @Override
    public void convertToDo(Token token) {
        BeanUtils.copyProperties(this, token);
    }

    @Override
    public void convertToDto(Token token) {
        BeanUtils.copyProperties(token, this);
    }
}
