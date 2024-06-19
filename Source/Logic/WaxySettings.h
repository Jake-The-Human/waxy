/*
  ==============================================================================

    WaxySettings.h
    Created: 16 Jun 2024 6:50:09pm
    Author:  jakep

  ==============================================================================
*/

#pragma once

#include <JuceHeader.h>

struct WaxySettings
{
    ~WaxySettings() { clearSingletonInstance(); }
    WaxySettings() = default;

    JUCE_DECLARE_SINGLETON(WaxySettings, false)
};
