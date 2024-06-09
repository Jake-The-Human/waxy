#pragma once
#include <JuceHeader.h>

class FileListView :
    public juce::Component
{
public:
    virtual ~FileListView() = default;
    FileListView() = default;
    FileListView(const FileListView&) = default;
    FileListView(FileListView&&) = default;

    // juce::Component
    void paint(juce::Graphics& g) final;
    void resized() final;
};
