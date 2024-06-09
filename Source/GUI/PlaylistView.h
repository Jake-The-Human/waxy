#pragma once

#include "NowPlayingView.h"
#include "PlaylistBoxModel.h"

#include <JuceHeader.h>

class PlaylistView :
    public juce::Component
{
public:
    virtual ~PlaylistView() = default;
    PlaylistView();
    PlaylistView(const PlaylistView&) = default;
    PlaylistView(PlaylistView&&) = default;

    PlaylistView& operator=(const PlaylistView&) = default;
    PlaylistView& operator=(PlaylistView&&) = default;

    // juce::Component
    void paint(juce::Graphics& g) final;
    void resized() final;
private:
    NowPlayingView nowPlayingView_;
    juce::ListBox playlistListBox_;
    PlayListBoxModel playlistBoxModel_;
};
