#pragma once

#include <JuceHeader.h>

class PlaylistView :
    public juce::Component
{
public:
    virtual ~PlaylistView() = default;
    PlaylistView() = default;
    PlaylistView(const PlaylistView&) = default;
    PlaylistView(PlaylistView&&) = default;

    // juce::Component
    void paint(juce::Graphics& g) final;
    void resized() final;
};

