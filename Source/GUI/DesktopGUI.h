#pragma once
#include <JuceHeader.h>

#include "ProfileView.h"
#include "FileListView.h"
#include "PlaylistView.h"

class DesktopGUI : public juce::Component
{
public:
    virtual ~DesktopGUI() = default;
    DesktopGUI();

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    ProfileView profileView_;
    FileListView fileListView_;
    PlaylistView playlistView_;

    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (DesktopGUI)
};
