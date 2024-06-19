#pragma once

#include <JuceHeader.h>

class ProfileView : public juce::Component
{
public:
    virtual ~ProfileView() = default;
    ProfileView();

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    juce::Label searchBox_{"Search"};
 
    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (ProfileView)
};
