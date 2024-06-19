#pragma once

#include <JuceHeader.h>
#include "FileListBoxModel.h"

#include <memory>

class FileListView : public juce::Component
{
public:
    virtual ~FileListView() = default;
    FileListView();

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    juce::TableListBox tableListBox_;
    std::vector<Song> songs_;
    std::unique_ptr<FileListBoxModel> tableModel_;

    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (FileListView)
};
