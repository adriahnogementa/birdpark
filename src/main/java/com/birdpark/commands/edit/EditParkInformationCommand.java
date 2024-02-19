package com.birdpark.commands.edit;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditParkInformationCommand implements Command<Boolean> {

    private String parkName;
    private String parkLocation;
    private String parkDescription;
    private byte[] parkLogo;
}
