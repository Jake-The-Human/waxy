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
    DesktopGUI(const DesktopGUI &) = default;
    DesktopGUI(DesktopGUI &&) = default;

    DesktopGUI &operator=(const DesktopGUI &) = default;
    DesktopGUI &operator=(DesktopGUI &&) = default;

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    ProfileView profileView_;
    FileListView fileListView_;
    PlaylistView playlistView_;
};
