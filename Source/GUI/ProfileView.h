#pragma once

#include <JuceHeader.h>

class ProfileView :
    public juce::Component
{
public:
    virtual ~ProfileView() = default;
    ProfileView();
    ProfileView(const ProfileView&) = default;
    ProfileView(ProfileView&&) = default;

    // juce::Component
    void paint(juce::Graphics& g) final;
    void resized() final;
private:

};
