#pragma once

#include <JuceHeader.h>

class NowPlayingView :
    public juce::Component
{
public:
    virtual ~NowPlayingView() = default;
    NowPlayingView() = default;
    NowPlayingView(const NowPlayingView&) = default;
    NowPlayingView(NowPlayingView&&) = default;

    // juce::Component
    void paint(juce::Graphics& g) final;
    void resized() final;
};

