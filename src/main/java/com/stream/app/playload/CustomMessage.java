package com.stream.app.playload;

import lombok.*;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomMessage {
    private  String message;

    private boolean success=false;


}
