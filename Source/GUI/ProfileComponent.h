#pragma once

#include <JuceHeader.h>

class ProfileComponent : public juce::Component
{
public:
    virtual ~ProfileComponent() = default;
    ProfileComponent();

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    juce::Label searchBox_{"Search"};
 
    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (ProfileComponent)
};
