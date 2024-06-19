#pragma once
#include <JuceHeader.h>

#include "NowPlayingView.h"
#include "PlaylistBoxModel.h"

class PlaylistView : public juce::Component
{
public:
    virtual ~PlaylistView() = default;
    PlaylistView(std::shared_ptr<WaxyState> waxyState);

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    NowPlayingView nowPlayingView_;
    juce::ListBox playlistListBox_;
    PlayListBoxModel playlistBoxModel_;

    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (PlaylistView)
};
