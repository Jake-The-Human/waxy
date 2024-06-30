#pragma once

#include <JuceHeader.h>
#include "FileListBoxModel.h"

#include <memory>

class FileListComponent : public juce::Component
{
public:
    virtual ~FileListComponent() = default;
    FileListComponent();

    // juce::Component
    void paint(juce::Graphics &g) final;
    void resized() final;

private:
    juce::TableListBox tableListBox_;
    std::vector<Song> songs_;
    std::unique_ptr<FileListBoxModel> tableModel_;

    JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR (FileListComponent)
};
