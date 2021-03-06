package com.programyourhome.adventureroom.module.common.module;

import java.util.Arrays;
import java.util.Collection;

import com.programyourhome.adventureroom.dsl.regex.AbstractRegexDslAdventureModule;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.module.common.dsl.converters.DebugPrintActionConverter;
import com.programyourhome.adventureroom.module.common.dsl.converters.SetPropertyActionConverter;
import com.programyourhome.adventureroom.module.common.dsl.converters.StartScriptActionConverter;
import com.programyourhome.adventureroom.module.common.dsl.converters.WaitActionConverter;

public class CommonAdventureModule extends AbstractRegexDslAdventureModule {

    public static final String ID = "common";

    private CommonConfig config;

    public CommonAdventureModule() {
        this.initConfig();
    }

    private void initConfig() {
        this.config = new CommonConfig();
        this.config.id = ID;
        this.config.name = "Common";
        this.config.description = "Module with common actions";
    }

    @Override
    public void start(Adventure adventure, ExecutionContext context) {
        // No start actions needed.
    }

    @Override
    public CommonConfig getConfig() {
        return this.config;
    }

    @Override
    protected Collection<RegexActionConverter<?>> getRegexActionConverters() {
        return Arrays.asList(new WaitActionConverter(), new SetPropertyActionConverter(), new DebugPrintActionConverter(), new StartScriptActionConverter());
    }

    @Override
    public void stop(Adventure adventure, ExecutionContext context) {
        // Nothing to do here.
    }

}
